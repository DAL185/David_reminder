# david_reminder
A online system aimed at doctors and patiens,in order to help patients get in-time reminders,and let doctors monitor the condition of
unfinished reminders.

## Prerequisite
Tools you need to install:
* Jdk 1.7 or higher version
* Apache 1.7 or higher version
* Mysql
* Eclipse(optional)

## Run project
* Open [localhost:8080](http://localhost:8080) to make sure your tomcat has started

![image](https://github.com/DAL185/david_reminder/blob/master/reminder/Screenshot-Reminder/localhost.PNG)

### Doctor part
* Enter [Doctor login page](http://localhost:8080/reminder/admin-login.html) to sign in or sign up,default username:David password:111

![image](https://github.com/DAL185/david_reminder/blob/master/reminder/Screenshot-Reminder/login.PNG)

* After log in, you will see the list of reminders for different patients

![image](https://github.com/DAL185/david_reminder/blob/master/reminder/Screenshot-Reminder/member_list.PNG)

* You can click "Look unfinished reminders" to check a patient's unfinished reminders

![image](https://github.com/DAL185/david_reminder/blob/master/reminder/Screenshot-Reminder/member_edit.PNG)

* Also,in page of reminder list, you can click "Add new reminder" to release new reminder for a patient

![image](https://github.com/DAL185/david_reminder/blob/master/reminder/Screenshot-Reminder/addreminder.PNG)

### Patient part
* Enter [Patient login page](http://localhost:8080/reminder/admin-guest_login.html) to sign in or sign up,default username:david password:111

![image](https://github.com/DAL185/david_reminder/blob/master/reminder/Screenshot-Reminder/guest_login.PNG)

* After log in, you will see your reminder list

![image](https://github.com/DAL185/david_reminder/blob/master/reminder/Screenshot-Reminder/guestmember.PNG)

* If a doctor release a new reminder for you, you will see "You have a new reminder" on the top of page,and if you finish it, you can click the green button "Finished"
