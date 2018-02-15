# Remove all variables
rm(list = ls())

#close graphic windows
graphics.off()

# clear screen
cat("\014")

# install packeges
# install.packages('corrplot')
# install.packages('car')

library(corrplot)
library(car)

head(cars)
head(Prestige)

head(Prestige, 20)

str(Prestige)

summary(Prestige)

# Subset data to capture just income, education, women and prestige 

newdata <- Prestige[,c(1:4)]
summary(newdata)

# plot density of income
plot(density(newdata$income), main = "Density Plot: Income", ylab = "Frequency", sub = paste(e1071::skewness(newdata$income),2), col="red")

plot(newdata, pch=16, col="blue", main="Matrix Scatterplot of Income, Education, Women and Prestige")

# Preprocess data, anter predictors

education.c <-scale(newdata$education, center = TRUE, scale = FALSE)
prestige.c <-scale(newdata$prestige, center = TRUE, scale = FALSE)
women.c <-scale(newdata$women, center = TRUE, scale = FALSE)

# bind these new variable into new data and apply a summary
new.c.vars <- cbind(education.c, prestige.c, women.c)
newdata <- cbind(newdata, new.c.vars)

names(newdata)[5:7] = c("education.c", "prestige.c", "women.c")
summary(newdata)

# Fit a linear model and run a summary of its result
mod1 <- lm(income ~education.c + prestige.c + women.c, data = newdata)
summary(mod1)

# plot a correlation graph
newdatacor = cor(newdata[1:4])
corrplot(newdatacor, method = "number")

# clear console
cat("\014")

# fit a linear model, excluding the variable education
mod2 <- lm(income ~ prestige.c +women.c, data = newdata)
summary(mod2)

# plot model residuals 
plot(mod2, pch=16, which = 1)

