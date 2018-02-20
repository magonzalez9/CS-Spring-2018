
summary(cars)
mean(cars$speed)

# Arrays
people <- array(c("Marco", "Chicken", "Alfredo"), dim = c(2,2))
print(people)

#while loop
n <- 1
while (n<5){
  print("Hello World")
  n = n+1
}

#For loop 
for (i in 1:10){
  print(paste("Your scale is: ", i))
}

## Create vector with elements from 5 to 9 incrementing by 2.
numb_seq <- seq(1,20, by = 3)
print(numb_seq)


# Matrix 
scale <- matrix(seq(1,10, by = 2), nrow = 5,ncol = 3, byrow = TRUE)
print(scale)

print(scale[5,2])

#function
sayHI <- function(x){
  print(x)
}

sayHI(21)

plot(cars$speed)