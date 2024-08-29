/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const password = document.getElementById("password");
const confirmPassword = document.getElementById("confirmPassword");
const message = document.getElementById("message");
const registerBtn = document.getElementById("registerButton");

if(confirmPassword != null) {
    document.addEventListener("input", () => {
        if(password.value != confirmPassword.value) {
            message.style.color = "red";
            message.textContent = "Passwords do not match";
            registerBtn.disabled = true;
        }
        else {
            message.textContent = " ";
            registerBtn.disabled = false;
        }
    });
}

