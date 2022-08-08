<%-- 
    Document   : index
    Created on : 06-Aug-2022, 10:46:13 PM
    Author     : shubh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <title>Insert title here</title>
   </head>
   <body>
      <form method="post" action="PurchaseDetail" >
         T-Shirt Accessories
         <input type="checkbox" name="access" value="Belt"/>Belt
         <input type="checkbox" name="access" value="Cap"/>Cap
         <input type="checkbox" name="access" value="Hair-Band"/>Hair-Band<br>
         Tag-Line<input type="text" name="tagline" size="50"/><br>
         T-Shirt Feature:
         <input type="radio" name="pocket" value="ChestPocket"/>Chest
         Pocket
         <input type="radio" name="pocket" value="NoChestPocket"/>No Chest Pocket<br>
         T-Shirt Color:
         <select name="Tshirtcolor">
            <option>Blue</option>
            <option>Red</option>
            <option>Green</option>
         </select>
         <br>
         <input type="submit" value="Place Orders"/>
      </form>
   </body>
</html>

