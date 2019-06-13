var demo = new Vue({
    el: '#demo',
    data: {
        message: 'Hello, Singree!'
    }
})


$("#track-like").click(
    function like(userId) {
        $.ajax({
            url: "/gramophone/api/track/1/like",
            type: "PUT",
            data: {
                userId: userId
            },
            contentType: 'application/json',
            dataType: 'json',
        })
            .done(function () {
                alert("success");
            })
            .fail(function () {
                alert("error");
            })
            .always(function () {
                alert("complete");
            });
    }
)