# include knn stuff
library(class)
iris
head(iris)
str(iris)
# split into training and test set

idxs <- sample(1: nrow(iris), as.integer(0.7 * nrow(iris)))

trainIris <- iris[idxs,]
testIris <- iris[-idxs,]

# A 1-nn neighbor model with no normalization 1:4 b/c 5 is the label (Species)
nn1 <- knn(trainIris[, 1:4], testIris[,1:4], iris$Species[idxs], k = 1)

table(testIris[,'Species'],nn1)