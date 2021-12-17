function outputCartRow(file, title, quantity, price, total){
	document.write('<tr>');
	document.write('<td><img src=" '+ file +'"></td>');
	document.write('<td>' + title + '</td>');
	document.write('<td class="center">' + quantity + '</td>');
	document.write('<td class="right">$' + price.toFixed(2) + '</td>');
	document.write('<td class="right">$' + total.toFixed(2) + '</td>');
	document.write('</tr>');
}
function calculateTotal(quantity, price){
	return quantity * price;
}
function calculateTax(subtotal, tax_rate){
	return subtotal * tax_rate;
}
function calculateShipping(subtotal, shipping_max){
	if (subtotal > shipping_threshold){
		return 0;
	}
	else{
		return 40;
	}	
}
function calculateGrandTotal(subtotal, tax, shipping){
	return subtotal + tax + shipping;
}

function outputCurrency(num){
	document.write("$" + num.toFixed(2));
}

