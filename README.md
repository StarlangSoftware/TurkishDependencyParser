Dependency TreeBanks
============

Tesnière introduced the dependency trees, structural order, the concept of dependency and applied his representation concepts in a variety of languages such as French, Greek, Russian, Italian, and so on. In structural order, syntactic relations are presented in a hierarchical manner as opposed to the linear order. He uses “stemmas” to reflect hierarchy. 

Today, dependency grammars are divided into two. One study from the tradition that applies this distinction to the dependency grammar is the Prague Dependency Treebank (PDT) developed by the Prague School of Functional and Structural Linguistics. A famous example for the other school of thought that displays linear order is the Penn Treebank that functioned between the years of 1989-1996, containing seven million annotated texts from American English. 

In 2005, The Stanford Dependencies developed for the parsing of the English language and to be used in NLP studies and in Stanford Dependency Parser. Stanford Dependencies were acknowledged as the standard for the dependency analyses of English. However, the Stanford Dependency parser could not reach an adequate accuracy when it was used with other dependency schemes. In the following years, the Universal Dependency Treebank (UDT) project pioneered to develop treebanks for languages other than English by transforming the Stanford dependencies into a more inclusive annotation scheme for a diverse set of languages.

The developments in the dependency treebanking made it clear that Turkish language needed a Treebank of its own. The first Turkish language dependency treebank is METU-Sabanci Turkish Treebank. This treebank used a corpus that consisted of 7,262 sentences and included morphological and syntactic annotations. In 2016, this tree-bank was revisited under the name of ITU-METU-Sabancı Treebank (IMST) to reduce the inconsistencies of its earlier version. They succeeded to reduce inconsistencies by applying a new annotation scheme. As a last step, The Bogazici-ITU-METU-Sabancı Treebank (BIMST) is updated as the same corpus. Having a linguistic team of three people, they created a new annotation scheme for IMST and manually re-annotated the data of 5.635 sentences while introducing new dependency relations that were not present in IMST.

Video Lectures
============

[<img src=video1.jpg width="50%">](https://youtu.be/zi4BYtZV9JE)[<img src=video2.jpg width="50%">](https://youtu.be/vS5o49V0wrU)

Class Diagram
============

<img src="classDiagram.png">

For Developers
============
You can also see either [Python](https://github.com/starlangsoftware/TurkishDependencyParser-Py), [Cython](https://github.com/starlangsoftware/TurkishDependencyParser-Cy), [C++](https://github.com/starlangsoftware/TurkishDependencyParser-CPP), [C](https://github.com/starlangsoftware/TurkishDependencyParser-C), [Swift](https://github.com/starlangsoftware/TurkishDependencyParser-Swift), [Js](https://github.com/starlangsoftware/TurkishDependencyParser-Js), or [C#](https://github.com/starlangsoftware/TurkishDependencyParser-CS) repository.

## Requirements

* [Java Development Kit 8 or higher](#java), Open JDK or Oracle JDK
* [Maven](#maven)
* [Git](#git)

### Java 

To check if you have a compatible version of Java installed, use the following command:

    java -version
    
If you don't have a compatible version, you can download either [Oracle JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) or [OpenJDK](https://openjdk.java.net/install/)    

### Maven
To check if you have Maven installed, use the following command:

    mvn --version
    
To install Maven, you can follow the instructions [here](https://maven.apache.org/install.html).      

### Git

Install the [latest version of Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git).

## Download Code

In order to work on code, create a fork from GitHub page. 
Use Git for cloning the code to your local or below line for Ubuntu:

	git clone <your-fork-git-link>

A directory called DependencyParser will be created. Or you can use below link for exploring the code:

	git clone https://github.com/starlangsoftware/TurkishDependencyParser.git

## Open project with IntelliJ IDEA

Steps for opening the cloned project:

* Start IDE
* Select **File | Open** from main menu
* Choose `DependencyParser/pom.xml` file
* Select open as project option
* Couple of seconds, dependencies with Maven will be downloaded. 


## Compile

**From IDE**

After being done with the downloading and Maven indexing, select **Build Project** option from **Build** menu. After compilation process, user can run DependencyParser.

**From Console**

Go to `DependencyParser` directory and compile with 

     mvn compile 

## Generating jar files

**From IDE**

Use `package` of 'Lifecycle' from maven window on the right and from `DependencyParser` root module.

**From Console**

Use below line to generate jar file:

     mvn install

============
+ [Maven Usage](#maven-usage)


### Maven Usage

        <dependency>
            <groupId>io.github.starlangsoftware</groupId>
            <artifactId>DependencyParser</artifactId>
            <version>1.0.27</version>
        </dependency>

# Cite

	@INPROCEEDINGS{9259799,
  	author={A. {Kuzgun} and N. {Cesur} and B. N. {Arıcan} and M. {Özçelik} and B. {Marşan} and N. {Kara} and D. B. {Aslan} and O. T. {Yıldız}},
  	booktitle={2020 Innovations in Intelligent Systems and Applications Conference (ASYU)}, 
  	title={On Building the Largest and Cross-Linguistic Turkish Dependency Corpus}, 
  	year={2020},
  	volume={},
  	number={},
  	pages={1-6},
  	doi={10.1109/ASYU50717.2020.9259799}}
