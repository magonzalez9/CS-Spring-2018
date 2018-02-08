ClicksDay1<-sum(subset(datasets, Day==1)$Clicks)
ClicksDay2<-sum(subset(datasets, Day==2)$Clicks)
ClicksDay3<-sum(subset(datasets, Day==3)$Clicks)
ClicksDay4<-sum(subset(datasets, Day==4)$Clicks)
ClicksDay5<-sum(subset(datasets, Day==5)$Clicks)
ClicksDay6<-sum(subset(datasets, Day==6)$Clicks)
ClicksDay7<-sum(subset(datasets, Day==7)$Clicks)
ClicksDay8<-sum(subset(datasets, Day==8)$Clicks)
ClicksDay9<-sum(subset(datasets, Day==9)$Clicks)
ClicksDay10<-sum(subset(datasets, Day==10)$Clicks)
ClicksDay11<-sum(subset(datasets, Day==11)$Clicks)
ClicksDay12<-sum(subset(datasets, Day==12)$Clicks)
ClicksDay13<-sum(subset(datasets, Day==13)$Clicks)
ClicksDay14<-sum(subset(datasets, Day==14)$Clicks)
ClicksDay15<-sum(subset(datasets, Day==15)$Clicks)
ClicksDay16<-sum(subset(datasets, Day==16)$Clicks)
ClicksDay17<-sum(subset(datasets, Day==17)$Clicks)
ClicksDay18<-sum(subset(datasets, Day==18)$Clicks)
ClicksDay19<-sum(subset(datasets, Day==19)$Clicks)
ClicksDay20<-sum(subset(datasets, Day==20)$Clicks)
ClicksDay21<-sum(subset(datasets, Day==21)$Clicks)
ClicksDay22<-sum(subset(datasets, Day==22)$Clicks)
ClicksDay23<-sum(subset(datasets, Day==23)$Clicks)
ClicksDay24<-sum(subset(datasets, Day==24)$Clicks)
ClicksDay25<-sum(subset(datasets, Day==25)$Clicks)
ClicksDay26<-sum(subset(datasets, Day==26)$Clicks)
ClicksDay27<-sum(subset(datasets, Day==27)$Clicks)
ClicksDay28<-sum(subset(datasets, Day==28)$Clicks)
ClicksDay29<-sum(subset(datasets, Day==29)$Clicks)
ClicksDay30<-sum(subset(datasets, Day==30)$Clicks)
ClicksDay31<-sum(subset(datasets, Day==31)$Clicks)

d = NULL
for (day in 1:31){
  CTRDayTemp <- sum(subset(datasets, Day==day)$Clicks)/sum(subset(datasets, Day==day)$Impressions)
    d= rbind(d, data.frame(day, CTRDayTemp))
}

b<-qplot(x=d$day, y=d$CTRDayTemp, geom = "step")
b+labs(title = "CTR Rate by Day", x = "Day", y= "CTR")


library(ggplot2)
library(reshape2)

x <- c(ClicksDay1,ClicksDay2,ClicksDay3,ClicksDay4,ClicksDay5,ClicksDay6,ClicksDay7,ClicksDay8,ClicksDay9,ClicksDay10,ClicksDay11,ClicksDay12, +
         ClicksDay13, ClicksDay14, ClicksDay15, ClicksDay16, ClicksDay17, ClicksDay18, ClicksDay19, ClicksDay20, ClicksDay21, ClicksDay22, ClicksDay23, +
         ClicksDay24, ClicksDay25, ClicksDay26, ClicksDay27, ClicksDay28, ClicksDay29, ClicksDay30, ClicksDay31)
day <- c(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31)

df1 <- data.frame(x,day)
df2 <- melt(df1, id.vars='day')
head(df2)

p <- ggplot(df2, aes(x=day, y=value, fill=variable)) +
  geom_bar(stat='identity', position='dodge')
p +labs(title = "Clicks by Day Graph", subtitle = "Rachel, Maha, Marco, DJ")+labs(caption = "based on data from The New York Times") +labs(x="Day") +labs(y="Clicks")


