function submitComplaint() {

    if (!navigator.geolocation) {
        alert("Geolocation is not supported.");
        return;
    }

    navigator.geolocation.getCurrentPosition(

        function(position) {

            const latitude = position.coords.latitude;
            const longitude = position.coords.longitude;

            console.log("Latitude :", latitude);
            console.log("Longitude :", longitude);

            sendToBackend(latitude, longitude);

        },

        function(error) {

            alert("Unable to fetch location");

        }

    );

}