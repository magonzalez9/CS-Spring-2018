x_1 <- rnorm(100,5,7)

hist(x_1,col="grey")
true_error <- rnorm(1000,0,2)
true_beta_0 <- 1.1
true_beta_1 <- 8.2

y <- true_beta_0 + true_beta_1*x_1 +true_error
