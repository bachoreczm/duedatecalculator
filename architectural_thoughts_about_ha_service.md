# Architectural thought about HA service

## Problems and facts

This is a simple java business logic.
It is easy to implement a REST API which serves this logic.

## To be cloud native
This simple java REST service can be run in a docker container.
This can be in a Pod in Kubernetes.

## Scalability
This Pod can be a template in a Deployment to be able to scale and upgrade our logic.

## Availability
To expose the API, we need a Service resource and maybe an Ingress resource, which points to our Pods in our Deployment. The Service balances the load between pods.

## High Availability
The best thing will be if our Kubernetes cluster will be scalable or more, if we are able to start another cluster and create a loadbalancer between our clusters.
