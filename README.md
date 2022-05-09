# crm

Using :  
---
    h2 database
    Java: Spring boot
    Spring security: BCrypt驗證密碼
    Spring data Jpa
    Junit 5
    Maven
    API document: Springfox 
    Builder Design Pattern
需求：
---  
    1.根據權限可以存取不同的API. 
      a. super-user: access to all functions.
      b. manager: modify/delete/view company/client data.
      c. operator: create/view company/client data.    
    2.完成公司新刪修查 
    3.完成客戶新增多筆及查詢：解決Ｎ+1 Query
  
連線測試：
---
    測試使用者：密碼為admin

    INSERT INTO user (username, password, roles) VALUES ('op2', '$2a$10$VrTzv.mHcJMwq/gg1421EOtDAT3kp1IEnsquxYR5k33d489MJJScC', 'OPERATOR'); 
    INSERT INTO user (username, password, roles) VALUES ('mg2', '$2a$10$VrTzv.mHcJMwq/gg1421EOtDAT3kp1IEnsquxYR5k33d489MJJScC', 'MANAGER'); 
    INSERT INTO user (username, password, roles) VALUES ('su2', '$2a$10$VrTzv.mHcJMwq/gg1421EOtDAT3kp1IEnsquxYR5k33d489MJJScC', 'SUPER_USER'); 

