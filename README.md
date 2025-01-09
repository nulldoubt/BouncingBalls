# Bouncing-Balls

Ever wanted to have some bouncing balls on your **desktop**? Using [libGDX](https://libgdx.com/)?

Well, I've got your back! (At least for Windows, Linux, MacOS)

###### **Linux and MacOS weren't tested.

---

## Structure

This project here was created in a couple of minutes, so don't judge the structure!

Although it's a regular [libGDX](https://libgdx.com/) project, there only a single gradle module called `:application`, 
which is the equivalent of both the `:core` and `:lwjgl3` projects combined 
(when generating using [gdx-liftoff](https://github.com/libgdx/gdx-liftoff)).

So **ALL** of the code is in the application subproject.

---

## Building and Running

How do you run the project then?

You could **either**:

* *Clone/Fork/Download* the repository on your computer, run a shell 
in the project directory, and execute the following command: 

  * `./gradlew :application:run`

* Import the repository into your favorite IDE 
(mine is [IntelliJ IDEA](https://www.jetbrains.com/idea/)) 
and execute the gradle task `run` from the `application` subproject.

* Download the latest JAR file and either double click it (OS-dependent), or run 
the `java -jar /path/to/jar` 


### For now, the only way to remove all the balls is to *terminate* the process. 

---

## Enjoying the project?

Thanks, you may star the project to show your contributions to the community!

Also, special thanks to [libGDX](https://libgdx.com/). That framework is literally one of its kind.
