 <#include "../zoomacro/macro_zpage.ftl" />
<@m_zoo_zpage_layout_head p_css="webjars/zoostatic/zstatic/manage/home.css" p_js="webjars/zoostatic/zstatic/manage/home.js"/>

 
 
 
<@m_zoo_zpage_layout_body />

 <nav class="navbar  navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home icon_margin" aria-hidden="true"></span>管理后台</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user icon_margin" aria-hidden="true"></span>逄小杰</a></li>
            <li><a href="#">设置</a></li>
            <li><a href="#">消息&nbsp;&nbsp;<span class="badge">42</span></a></li>
            <li><a href="">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar" id="manage_home_sidebar">
          
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">你好，新体优家</h1>

          <div class="row ">
            <div id="zoo_content" class="zs_page_form_box"></div>
            
            
            
          </div>

          
        </div>
      </div>
    </div>


<@m_zoo_zpage_html_initjs p_js="manage_home.index()" />
<@m_zoo_zpage_layout_foot />