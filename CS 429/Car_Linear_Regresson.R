head(cars) #built in dataset
dim(cars)
summary(cars)

scatter.smooth(x = cars$speed, y = cars$dist, main = "Dist ~ Speed") # scatterplot

#Boxplot
par(mfrow = c(2,2)) #divide graph area in 2 colums
boxplot(cars$speed, main = "Speed", sub = paste("Outlier rows: ", boxplot.stats(cars$speed)$out))
boxplot(cars$dist, main = "Distance", sub = paste("Outlier rows: ", boxplot.stats(cars$dist)$out))

#install.packages("e1071")
library(e1071)
par(mfrow = c(2,2)) # divide graph area in 2 columns
plot(density(cars$speed), main = "Density Plot: SPeed", ylab = "Frequency", sub = paste(e1071::skewness(cars$speed),2)) #density plot for speed
polygon(density(cars$speed), col = "red")
plot(density(cars$dist), main = "Density Plot: Distance", ylab = "Frequency", sub = paste(e1071::skewness(cars$dist),2)) #density plot for dist
polygon(density(cars$dist), col = "blue")

cor(cars$speed, cars$dist) # the closer to Juan the better

linearMod <- lm(dist ~ speed, data = cars) #x and y would be two columns in the karz 
print(linearMod)

summary(linearMod)