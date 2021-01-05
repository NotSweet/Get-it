   function showResult(str)
    {
      var xmlHttp;
      if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlHttp=new XMLHttpRequest();
        }
      else
        {// code for IE6, IE5
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
    xmlHttp.onreadystatechange=function()
    {
    if (xmlHttp.readyState==4 && xmlHttp.status==200)
    {
    var text =  xmlHttp.responseText;
    obj = JSON.parse(text);
    for (var i=0;i<obj.length;i++)
    {
    var task_title = obj[i].task_title;
    var status = obj[i].status;
    var task_author = obj[i].task_author;
    var task_address = obj[i].task_address;
    var task_context = obj[i].task_context;
    var task_other = obj[i].task_other;
    var task_id = obj[i].task_id;
    var task_phone = obj[i].task_phone;
    var task_type = obj[i].task_type;
    var task_score = obj[i].task_score;
    var updateAt = obj[i].updateAt;
    var createAt = obj[i].createAt;
    var pic = i%10+1;
    var T1 = document.getElementById("tableTask").insertRow(1);
    T1.innerHTML=['<td width="50%">',
                 '                                      <div class="mui-panel">',
                 '                                          <div>',
                 '                                              <img width="70" height="70" src="mui-0.9.27/ico_'+pic+'.png"',
                 '                                                   style="float:left; margin-right:20px"/> <a',
                 '                                                  class="mui--text-dark mui--text-headline">'+task_title,
                 '                                          </a>',
                 '                  ',
                 '                                              <div class="mui--text-dark mui--text-subhead">'+task_context+'</div>',
                 '                                          </div>',
                 '                                          <br> &nbsp<a class="mui--text-accent mui--text-body1">'+task_phone+'</a>·',
                 '                                          悬赏：<span class="mui--text-accent mui--text-body1">'+task_score+'</span> <span',
                 '                                              style="float:right;" class="mui--text-accent mui--text-body1">'+createAt+'</span>',
                 '                                      </div>',
                 '                                  </td>'].join("");

       }
    }
    }
    xmlHttp.open('GET','/task/123');
    xmlHttp.send();
    }