datasets$ageCategory <- cut(datasets$Age,c(0,18,24,34,44,54,64,120))

install.packages("ggplot2")
library(ggplot2)

datasetsImpressions <- subset(datasets, Impressions>0)
datasetsClicks <- subset(datasets,Clicks>0)
 
datasetsImpressions$ctr <- datasetsImpressions$Clicks/datasetsImpressions$Impressions 
meanCTR = mean(datasetsImpressions$ctr)

ggplot(subset(datasets,Impressions>0), aes(x=Age/Clicks, colour = ageCategory)) + geom_density()
print(ageClicks + labs(
                       x = "Age Click Rate"))
ggplot(subset(datasets), aes(x=Age/Clicks, colour = ageCategory)) + geom_density()

qplot(datasets$Clicks, geom="histogram") 
qplot(datasets$Impressions,binwidth = 0.5,geom="histogram")





