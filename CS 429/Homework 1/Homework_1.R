#categorize
head(datasets)
datasets$agecat <-cut(datasets$Age, c(-Inf,0,18,24,34,44,54,64,Inf))

#view
summary(datasets)

#brackets
install.packages("doBy")
library("doBy")
siterange <- function(x){c(length(x), min(x),mean(x),max(x))}
summaryBy(Age~agecat, data =datasets, FUN=siterange)

#plot
install.packages("ggplot2")
library(ggplot2)

plot(x,y)