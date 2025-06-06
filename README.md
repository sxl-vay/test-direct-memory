# Test Direct memory leak

> start this project,Accessing in browser  http://localhost:8080 and upload a file many times.When you have completed the file upload,you can see the memory usage,Just like the picture below

![img.png](img.png)
> When the total size of the images you upload exceeds the direct memory capacity, OOM occurs,Just like the picture below

![img_1.png](img_1.png)

> To help you recurrent this error, when you start this test project,can add a jvm args
```
-XX:MaxDirectMemorySize=512m
```
