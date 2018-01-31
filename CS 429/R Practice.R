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





