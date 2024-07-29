async function listBlogs() {
    const listBlogs = await getAllBlogs();
    renderBlogs(listBlogs);
}

async function searchBlogs() {
    const listBlogs = await searchByTitle();
    renderBlogs(listBlogs);
}

listBlogs()

function renderBlogs(listBlogs) {
    console.log(listBlogs)
    if (!listBlogs) {
        isEmpty = `<h3 class="text-center">Danh sách rỗng!</h3>`
        $('#list-blogs').html(isEmpty)
        return;
    }
        let blog = '';
    listBlogs.content.forEach(el => {
        console.log(el);
        blog += `<div class="row">
       <div class="col-11">
           <h6><span>Tác giả: </span><span>${el.author}</span></h6>
           <a class="text-decoration-none text-dark" href="/blogs/detail/${el.id}">
               <h4>${el.title}</h4>
           </a>
           <div ${el.category != null}">
               <span class="badge bg-primary">${el.category.name}</span>
           </div>
       </div>
       <div class="col-1 align-content-end">
           <div class="dropdown">
               <div style="cursor: pointer" data-bs-toggle="dropdown" aria-expanded="false">
                   <i class="bi bi-list-ul fs-3"></i>
               </div>
               <ul class="dropdown-menu">
                   <li><a class="dropdown-item" href="/blogs/update/${el.id}">Chỉnh sửa</a></li>
                   <li><a class="dropdown-item" href="/blogs/delete/${el.id}">Xóa</a></li>
               </ul>
           </div>
       </div>
   </div>
   <hr>`;
    })
    $('#list-blogs').html(blog);
    
    
}