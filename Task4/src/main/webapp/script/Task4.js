/**
 * Created by rahil on 21/12/21.
 */
function makeVisible(){
    document.getElementById("inputform").style.display="block";
}

function addRow(){


    var Name=document.getElementById("name").value;
    var Surname=document.getElementById("surname").value;
    var Username= document.getElementById("username").value;
    var Email=document.getElementById("email").value;
    var Password=document.getElementById("password").value;
    var Confirm_password=document.getElementById("confirmpassword").value;
    const rbs = document.querySelectorAll('input[name="xyz"]');
    let Auth;
    for (const rb of rbs) {
        if (rb.checked) {
            Auth = rb.value;
            break;
        }
    }
    const rbss = document.querySelectorAll('input[name="status"]');
    let Status;
    for (const rb of rbss) {
        if (rb.checked) {
            Status = rb.value;
            break;
        }
    }
    var Department=document.getElementById("department").value;
    var Rolegroup=document.getElementById("role").value;
    var Description=document.getElementById("description").value;
    
    
    
    
    
    
    
    
    

















    /*


    var table=document.getElementById("tab1");
    var row=table.insertRow(-1);

    var uname=row.insertCell(0);
    var auth=row.insertCell(1);
    var dpt=row.insertCell(2);
    var status=row.insertCell(3);
    var rolegroup=row.insertCell(4);
    var Email=row.insertCell(5);
    var Description=row.insertCell(6);
    var deletecell=row.insertCell(7);
    uname.innerHTML=username;
    dpt.innerHTML=department
    rolegroup.innerHTML=role;
    Email.innerHTML=email;
    Description.innerHTML=description;
    auth.innerHTML=selectedValue1;
    status.innerHTML=selectedValue2;
    deletecell.innerHTML=createBtn();


    */
    document.getElementById("inputform").style.display="none";

        $.ajax({
            type: "POST",
            data:{
                 name:Name,
                 surname:Surname,
                 username:Username,
                 email:Email,
                 password:Password,
                 confirm_password:Confirm_password,
                 auth:Auth,
                 status:Status,
                 department:Department,
                 rolegroup:Rolegroup,
                 description:Description
            },
            url: "dbAccess",
            success:function (json) {//obj
                alert("data added");
                var opened = window.open("");
                opened.document.write(json);
            //console.log(obj.typeName);
            }
        });


    return false;
}

function createBtn(){
    return "<button id='btnDelete' class='delBtn' onclick=delRow(this)>Delete</button>";
}

function delRow(obj){
    var obj1=obj.parentNode.parentNode.rowIndex;
    //alert(obj1);
    document.getElementById("tab1").deleteRow(obj1);
    // document.getElementById("tab1").deleteRow(thisrow.rowIndex);
}

// function connectToDB() {
//     $.ajax({
//         type: "GET",
//         url: "dbAccess",
//         success:function (obj) {
//
//             var opened = window.open("");
//             opened.document.write(obj);
//             //console.log(obj.typeName);
//         }
//     });
// }
