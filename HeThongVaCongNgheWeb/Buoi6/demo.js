var arr = new Array();
arr[0] = "thu hai";
arr[1] = "Thu ba";
arr[2] = "Thu tu";
arr[3] = "Thu nam";
arr[4] = "Thu sau";
arr[5] = "Thu bay";

for (i = 0; i <= 5; i++)
    document.write(arr[i] + "<br>");
document.write(arr.length + "<br>");

var arrName = new Array(3)
arrName[0] = "Jani"
arrName[1] = "Tove"
arrName[2] = "Hege"
document.write(arrName.length + "<br>")
document.write(arrName.join(".") + "<br>")
document.write(arrName.reverse() + "<br>")
document.write(arrName.sort() + "<br>")
document.write(arrName.push("Ola", "Jon") + "<br>")
document.write(arrName.pop() + "<br>")
document.write(arrName.shift() + "<br>")