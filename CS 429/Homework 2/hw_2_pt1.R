# numb of observations,mean, st_deviation
x_1 <- rnorm(1000,5,7)

hist(x_1,col="grey")
true_error <- rnorm(1000,0,2)
true_beta_0 <- 1.1
true_beta_1 <- 8.2

y <- true_beta_0 + true_beta_1*x_1 + true_error
hist(y) #plot p(y)

# a. Build a regression model
plot(x_1,y, pch=20,col="red") #plot p(x,y)
mod <- lm(y ~ x_1)

# create new
x_2 <- rgamma(1000,2,4)
true_gamma <- -8.1

y2 <- true_beta_0 + true_beta_1*x_1 + true_gamma + x_2 * true_error

mod2 <- lm(y2 ~ x_2)
mod3 <- lm(y2 ~ x_1)
mod4 <- lm(y2 ~ x_2+x_1)

for (i in 1000:10000) {

}




