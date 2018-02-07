#categorize
#i <- 1
#filename <- "~/Desktop/data/nyt".i.".csv"

#loop
for (day in 1:31){
  #print(paste("The day is", day))
  temp <- paste(c("~/Desktop/data/nyt", day), collapse = "")
  filename <- paste(temp, ".csv", sep="")
  print(filename)
  
  data<-read.csv(filename)
  
  summary(data)
}

