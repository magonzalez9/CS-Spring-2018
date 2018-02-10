
#View the nyt2 Data Set#
View(nyt2)


#Creating CTR (Click-Through-Rate(#Click/#Impressions)) variables for Age Groups 
#and for Gender#

#ImpressionsMClicks <- nyt2$Impressions - nyt2$Clicks
#ClicksDImpressions <- nyt2$Clicks / nyt2$Impressions
CTR18 <- subset(nyt2, Age<18 & Age>0)$Clicks / subset(nyt2, Age<18 & Age>0)$Impressions
CTR1824 <- subset(nyt2, Age>=18 & Age<=24)$Clicks / subset(nyt2, Age>=18 & Age<=24)$Impressions
CTR2534 <- subset(nyt2, Age>=25 & Age<=34)$Clicks / subset(nyt2, Age>=25 & Age<=34)$Impressions
CTR3544 <- subset(nyt2, Age>=35 & Age<=44)$Clicks / subset(nyt2, Age>=35 & Age<=44)$Impressions
CTR4554 <- subset(nyt2, Age>=45 & Age<=54)$Clicks / subset(nyt2, Age>=45 & Age<=54)$Impressions
CTR5564 <- subset(nyt2, Age>=55 & Age<=64)$Clicks / subset(nyt2, Age>=55 & Age<=64)$Impressions
CTR65 <- subset(nyt2, Age>=65)$Clicks / subset(nyt2, Age>=65)$Impressions


CTRFemale <- subset(nyt2, Gender==0)$Clicks / subset(nyt2, Gender==0)$Impressions
CTRMale <- subset(nyt2, Gender==1)$Clicks / subset(nyt2, Gender==1)$Impressions

#Performing exploratory Data Analysis (EDA) using a graphical approach to the data#
stripchart(CTR18, vertical=TRUE, pch=1, method="stack", ylab ="Click-Through-Rate for Age<18")
stripchart(CTR1824, vertical=TRUE, pch=1, method="stack", ylab ="Click-Through-Rate for Age 18-24")
stripchart(CTR2534, vertical=TRUE, pch=1, method="stack", ylab ="Click-Through-Rate for Age 25-34")


#Plotting the distributions of number of Click Through Rate for Age Groups
#and Genders#

hist(CTR18)
hist(CTR1824)
hist(CTR2534)
hist(CTR3544)
hist(CTR4554)
hist(CTR5564)
hist(CTR65)

hist(CTRFemale)
hist(CTRMale)


Imp18 <- density(subset(nyt2, Age<18 & Age>0)$Impressions)
plot(Imp18)
Imp1824 <- density(subset(nyt2, Age>=18 & Age<=24)$Impressions)
plot(Imp1824)
Imp2534 <- density(subset(nyt2, Age>=25 & Age<=34)$Impressions)
plot(Imp2534)
Imp3544 <- density(subset(nyt2, Age>=35 & Age<=44)$Impressions)
plot(Imp3544)
Imp4554 <- density(subset(nyt2, Age>=45 & Age<=54)$Impressions)
plot(Imp4554)
Imp5564 <- density(subset(nyt2, Age>=55 & Age<=64)$Impressions)
plot(Imp5564)
Imp65 <- density(subset(nyt2, Age>=65)$Impressions)
ggplot(Imp65)

##ggplot2::Imp65

ImpFemale <- density(subset(nyt2, Gender==0)$Impressions)
plot(ImpFemale)
ImpMale <- density(subset(nyt2, Gender==1)$Impressions)
plot(ImpMale)

library(ggplot2)
qplot(CTR18, geom="histogram")
##ggplot(data = nyt2, aes(nyt2$Age)) + geom_histogram()

summary(nyt2)

