<%@include file="userChecker.jsp"%>

<nav class="navbar navbar-expand-lg " style="background-color: rgb(237, 237, 237); color:black;">
  <a class="navbar-brand" href="/" style="color: black; margin-left: 10px">NEWS KZ</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup" style="margin-left: -10px">
    <%
      if(Online){

    %>
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="/profile" ><%=curretUser.getFullName()%> </a>
    </div>

    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="/logOut">Log out </a>
    </div>
    <%
      }else{
    %>
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="/home" >Top Sales </a>
    </div>

    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="/signIn" >Sign In </a>
    </div>

    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="/signUp" >Sign Up </a>
    </div>
    <%
      }
    %>
  </div>
</nav>