README for CS-305
* Briefly summarize your client, Artemis Financial, and its software requirements. Who was the client? What issue did the company want you to address?
    Aretemis Finacial is a consulting company that develops indvidialized financial plans for its customers. They required custom software to modernize their operations, and needed the software to be secure. Specifically, they needed to ensure secure communications with a data verification applicataion in the form of a checksum. 
    
   * What did you do well when you found your client’s software security vulnerabilities? Why is it important to code securely? What value does software security add to a company’s overall well-being?
       It is important to code securly as, not only do we have an ethical duty to protect the information we are entrusted with, but a legal obligation. Software security allows a company to avoid legal problems and loss of client trust if thier data is breeched.
     
   * Which part of the vulnerability assessment was challenging or helpful to you?
        Identifying the weaknesses in the code was challenging, as well as working with dependences that were out of date or insecure.
     
   * How did you increase layers of security? In the future, what would you use to assess vulnerabilities and decide which mitigation techniques to use.
       To increase the levels of security, I added code to create a checksum verification. I also reccomended using updated dependencies.
     
    * How did you make certain the code and software application were functional and secure? After refactoring the code, how did you check to see whether you introduced new vulnerabilities?
        I made sure the code worked by static testing, manaully inspecting the codd, and dynamicly testing to ensure the code worked. To check for introduced vulnerabilities, I red-ran the dependency report.
      
    * What resources, tools, or coding practices did you use that might be helpful in future assignments or tasks?
        Resources I used for this project were Maven dependncy check, Oracle coding guides, and forums such as StackOverflow
      
    Employers sometimes ask for examples of work that you have successfully completed to show your skills, knowledge, and experience. What might you show future employers from this assignment?
      I might show them the completed code from project 2, as I feel that best showcases the work I put into the project.
