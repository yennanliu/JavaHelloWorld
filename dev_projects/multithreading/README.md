# Multithreading

## General programming steps

- [Video](https://youtu.be/Qxj3CXqh4Wk?si=zoFHx85gSB6tUZVT&t=575)

- Step 1: Create resource class, implement attr, op method
- Step 2: implement method in resource class
	- decision
	- main biz logic
	- notification (other thread)
- Step 3: Create threads, call resource class
- Step 4: Avoid "虛假喚醒" (if logic)

## Command

```bash
#java -jar fernflower.jar -dgs=true JarToDecompile.jar DecompiledJar
#java -jar ref_project/jcip-examples-src.jar -dgs=true JarToDecompile.jar DecompiledJar
```

## Ref

- https://github.com/callicoder/java-concurrency-examples
- https://github.com/code-review-checklists/java-concurrency

- https://github.com/PacktPublishing/Java-Concurrency-Multithreading-in-Practice/tree/master
- https://jcip.net/
- https://jcip.net/listings.html