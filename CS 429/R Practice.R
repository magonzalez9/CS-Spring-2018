# R exercise

#if statements
if (4 >1){
  2+2
} else if (2 >1){
  4+4
}

#which
student.salary <- seq(10,200, by =2)
which(student.salary > 100 & student.salary < 150)
student.salary[which(student.salary >100 & student.salary <150)]

#Functions 
stats <- function(x) {
  m <- mean (x)
  std <- sd(x)
  se <- std/sqrt(length(x))
  return(c(m,std,se))
}

# Vectors
v <- c(7,6,4)
v + 1
v * 100
length(v)
sqrt(v)
w <- c(4,7,4)
v * w # Shorter vector is recycled if vectors are not same size
u <- c(10,20,20)
u * w
i <- 1:10 
small.ints <- i < 5
small.ints
which(small.ints) #Values corresponding to TRUE

# matrices
# matrix(v, nrow = 3, ncol = 4)
v <- 1:12
matrix(v, 3, 4)
matrix(v, 3, 4, byrow = TRUE)

m <- matrix(v, 3, 4, byrow = TRUE)
m
dim(m)
length(m)

head(m,2)
tail(m,2)
#subsetting
m[2,4]
m[1,]
m[,3]
m[1:2, 3]
m[3] #careful with this 

# List
alist <-list('Hello World', TRUE, 2:5, 3.141232)
alist[[1]]
alist[[3]]
alist[[3]][[3]] #to index, use double bracket

# Can add to list by naming element
alist[['me']] <- 'new element'
alist

alist$me
alist[[5]]

x <- 1 : 5
x 
x <- append(x, 4:6)
x
# R uses lexical scoping: a free variable is looked up in the environment in which it is defined
# Dynamic Scoping: the variable is looked up in the environment in which it is called

y <- 10
f <- function(x){
  y <-2
  y^2 + g(x)
}

g <- function(x){
 x*y 
}

f(3)

# Allows you to define function inside another function 

create_power <- function(n){
  power <- function (x) {
  x ^ n    
  }  
}

square <- create_power(2)
cube <- create_power(3)

square(2)
cube(3)

# determine working directory
getwd()
list.files()
#setwd() <- working direcory
climate <- read.csv('climate_data.csv')
str(climate)
summary(climate)
dim(climate)
head(climate, 3)
tail(climate, 3)
length(climate)
climate[2:4, 3:6]
climate[,1]
names(climate)
climate$Ozone
mean(climate$Ozone)
mean(climate$Ozone, na.rm = TRUE) #Remove NA's





