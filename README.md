# Walking stick for blind person

### BACKGROUND
This project was done for as a semester project. with the collabaration of [Ravindu Abewardhana](https://www.facebook.com/ravindu.abewardana) and [Aasif Luthfi](https://www.facebook.com/mlmaasif)

### DESCRIPTION
This is a java Application with an UI(for developers) for walking stick developed to use of Blind person
the application requires have the (**R**)ed (**G**)reen (**B**)lue values as percentages (Maximum and minimum values are pre-calculated) and the the application is processing the input data into RGB value. Finaly, the application can find the nearest color from the *mySQL* Database which is intergrated with the Application .
Data from the sensors are the values between 0 and 1023, that senaor data is collected by the microcontroller ATMEGA328P and them are sending through USART serial communication port. Then after the data recieved form the hardware, it is processing by the java program. The java program converts RGB Data into the range of 0 to 100 (colour percentages)
Because the database has percentage values of RGB of each color.
Finally the percentage value which is calculated by the java program is comparing with the database colors while calculating euclidean distance for nearest color values recieved 
