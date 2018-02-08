folder <- "C:/Users/rachh/OneDrive/Documents/Data Science/HW1_Data/"      # path to folder that holds multiple .csv files
file_list <- list.files(path=folder, pattern="*.csv") # create list of all .csv files in folder
# read in each .csv file in file_list and create a data frame with the same name as the .csv file

my_files <- list.files(pattern = "\\.csv$")

clickList <- list()
impressionsList <- list()

for (i in 1:length(file_list)){
         data1 <- read.csv(paste(folder, file_list[i], sep=''))
         meanClicks <- mean(data1$Clicks)
         meanImpressions <- mean(data1$Impressions)
        
         plot<-qplot(data1$Impressions,binwidth=1,geom="histogram")
         print(plot)
         clickList[i] <- meanClicks
         impressionsList[i] <- meanImpressions
        
}




