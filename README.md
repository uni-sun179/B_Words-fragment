入力値をNGワードかどうかを判定する簡易Webアプリの一部です。  
/Java/Checker/CheckAction.javaがその判定を行うコードとなっています。

#使用言語等  
-Java  
-HTML  
-CSS  
-Javaサーブレット    

#動作環境  
-Tomcat  
-MySQL  

#動作の流れ  
1.'index.jsp'のテキストボックスに判定したい文字列を入力  
2.文字列を判定。その後に、データベースに登録  
3.データベースから判定された文字列を最新の15件取得  
4.取得した文字列をリクエストパラメータで渡して、'checked.jsp'に遷移  
5.'checked.jsp'のテキストボックスに判定したい文字列を入力  
6.2に戻る  

#その他説明  
-NGワードと判定される語の基準は、Youtube上で規制されてそうな言葉です。  
-ご自身の環境で動作させる場合は、データベースの用意や、'context.xml'の用意、'/java/dao/DAO.java'の17行目の  修正が必要です。  
-'/sample' に動作させた際のスクリーンショットが入っています。仕様上、内容が若干下品ですので、ご注意ください。  
