<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <base href="${initParam.base_url}">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eriba</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery.easing.min.js"></script>
        <script type="text/javascript" src="js/jquery.lavalamp.min.js"></script>
        <script type="text/javascript">
          $(function() {
            $("#lava_menu").lavaLamp({
              fx: "backout",
              speed: 700
            });
          });
        </script>

        </head>

        <body>
        <div id="main">
            
            <%@include file='includes/menu.jsp' %>	
                <div id="content">
                    <div class="content_item">
                        <h1>Welcome</h1>
                        <div style="width:200px; float:left; padding: 0px 20px 10px 0px;"><img alt="image" src="img/image.jpg" /></div>
                        <p>
                           Lorem ipsum dolor sit amet, consectetur adipiscing 
                            elit. Sed quis enim fringilla, efficitur sem at, 
                            porta justo. Nullam sit amet consectetur velit, at 
                            laoreet eros. Nunc sit amet maximus metus. Sed 
                            sollicitudin maximus pellentesque. Vestibulum 
                            fermentum libero neque, quis pretium nibh facilisis 
                            molestie. Curabitur quis tincidunt quam, nec auctor 
                            ante. Curabitur non risus a ante tincidunt pharetra 
                            vitae eu dui. Aenean vel turpis viverra, posuere 
                            nunc et, tempus urna. Aliquam tristique mauris 
                            magna, aliquam lobortis nibh dictum eget. 
                        </p>
                    </div><!--close content_item-->	
                </div><!--close content-->	
                </div><!--close site_content-->	
            </div><!--close site_background-->	

            <%@include file='includes/footer.jsp' %>
        
        </div><!--close main-->	
    </body>
</html>
