const getAllBlogs = () => {
    return $.ajax({
        header: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: 'GET',
        url: 'http://localhost:8080/api/blogs'
    })
}


const searchByTitle = () => {
    let keyword = $('#keyword').val();

    return $.ajax({
        header: {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
        },
        type: 'GET',
        url: 'http://localhost:8080/api/blogs/search?keyword='+ keyword
    })
}
