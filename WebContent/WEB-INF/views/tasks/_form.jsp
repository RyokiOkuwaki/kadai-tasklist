<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<label for="title">タスク内容</label><br />
<input type="text" name="content" id="content" value="${tasks.content}" />
<br /><br />

<!--  <label for="content_msg">メッセージ</label><br />
<input type="text" name="content" id="content_msg" value="${message.content}" />
<br /><br />
-->

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">タスクの作成</button>