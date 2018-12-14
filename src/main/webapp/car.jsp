<!DOCTYPE html>
<html>
<head>
<title>Create Car</title>
</head>
<body>
	<div style="padding-left:100px;font-family: monospace;">
		<h2>Create Car</h2>
		<form action="webapi/vehicle" method="POST">
			<div style="width: 200px; text-align: left;">
				<div style="padding:10px;">
					 Car Consumption: <input name="consumtionType" />
				</div>
				<div style="padding:10px;">
					vehicletype: <input name="vehicletype" />
				</div>
				<div style="padding:10px;">
					cc: <input name="cc" />
				</div>
				<div style="padding:10px;">
					fuel: <input name="fuel" />
				</div>
				<div style="padding:10px;">
					brand: <input name="brand" />
				</div>
				<div style="padding:10px;text-align:center">
					<input type="submit" value="Submit" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>