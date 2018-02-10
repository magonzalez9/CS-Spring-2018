data1 <- read.csv("C:/Users/rachh/OneDrive/Documents/Data Science/HW1_data/nyt4.csv")

#categorize
head(data1)
data1$agecat <- cut(data1$Age,c(0,18,24,34,44,54,64,120))


#view
summary(data1)

# brackets 
install.packages("doBy")
library("doBy")
siterange <- function(x){c(length(x), min(x), mean(x), max(x))}
summaryBy(Age~agecat, data = data1, FUN=siterange)

#so only signed in users have ages and geners
summaryBy(Gender+Signed_In+Impressions+Clicks~agecat, data = data1)

#plot
install.packages("ggplot2")
library(ggplot2)
ggplot(data1, aes(x=Impressions, fill = agecat)) + geom_histogram(binwidth=1)
ggplot(data1, aes(x=agecat, y = Impressions, fill = agecat)) + geom_boxplot()

data1$hasimps <- cut(data1$Impressions, c(-Inf,0,Inf))
summaryBy(Clicks~hasimps, data = data1, FUN = siterange)
ggplot(subset(data1, Impressions>0), aes(Clicks/Impressions, colour=agecat)) + geom_density()
ggplot(subset(data1, Clicks>0), aes(x=Clicks/Impressions, colour=agecat)) + geom_density()
ggplot(subset(data1,Clicks>0), aes(x=agecat, y = Clicks, fill=agecat)) + geom_boxplot()
ggplot(subset(data1,Clicks>0), aes(x=Clicks, colour=agecat)) + geom_density()
ggplot(subset(data1,Clicks>0), aes(Age/Clicks, colour=agecat)) +geom_density()
meanClicks = mean(data1$Clicks)
medianClicks = median(data1$Clicks)
varianceClicks = variance(data1$Clicks)

meanImpressions = mean(data1$Impressions)
medianImpressions = median(data1$Impressions)
varianceImpressions = variance(data1$Impressions)

meanCTR = mean(data1$Clicks/data1$Impressions)


