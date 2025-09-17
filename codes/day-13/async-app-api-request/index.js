function showPosts(posts) {
  const postsBody = document.getElementById("postsBody");
  posts.forEach((p) => {
    const newRow = document.createElement("tr");
    const tdId = document.createElement("td");
    tdId.innerText = p.id;
    const tdUserId = document.createElement("td");
    tdUserId.innerText = p.userId;
    const tdTitle = document.createElement("td");
    tdTitle.innerText = p.title;
    const tdBody = document.createElement("td");
    tdBody.innerText = p.body;
    newRow.append(tdId, tdUserId, tdTitle, tdBody);
    postsBody.appendChild(newRow);
  });
}
async function fetchPosts() {
  try {
    const httpResponse = await fetch(
      "https://jsonplaceholder.typicode.com/posts"
    );
    const posts = await httpResponse.json();
    console.log(posts.slice(0, 10));
    showPosts(posts.slice(0, 10));
  } catch (err) {
    console.log(err.message);
  }
}

async function fetchPost(id) {
  try {
    const httpResponse = await fetch(
      `https://jsonplaceholder.typicode.com/posts/${id}`
    );
    const post = await httpResponse.json();
    console.log(post);
  } catch (err) {
    console.log(err.message);
  }
}

async function addPost(post) {
  try {
    const httpResponse = await fetch(
      `https://jsonplaceholder.typicode.com/posts`,
      {
        method: "POST",
        headers: {
          "Content-type": "application/json; charset=UTF-8",
        },
        body: JSON.stringify(post),
      }
    );
    const addedPost = await httpResponse.json();
    console.log(addedPost);
  } catch (err) {
    console.log(err.message);
  }
}

async function updatePost(id, post) {
  try {
    const httpResponse = await fetch(
      `https://jsonplaceholder.typicode.com/posts/${id}`,
      {
        method: "PUT",
        headers: {
          "Content-type": "application/json; charset=UTF-8",
        },
        body: JSON.stringify(post),
      }
    );
    const updatedPost = await httpResponse.json();
    console.log(updatedPost);
  } catch (err) {
    console.log(err.message);
  }
}

async function deletePost(id) {
  try {
    const httpResponse = await fetch(
      `https://jsonplaceholder.typicode.com/posts/${id}`,
      {
        method: "DELETE",
      }
    );
    const deletedPost = await httpResponse.json();
    console.log(deletedPost);
    console.log(httpResponse.status, httpResponse.statusText);
  } catch (err) {
    console.log(err.message);
  }
}
fetchPosts();
//fetchPost(2);
//addPost({
//   userId: 1,
//   title: "fetch API",
//   body: "used to send async network requests"
// })

// updatePost(1, {
//   userId: 1,
//   title: "fetch DOM API",
//   body: "used to send async network requests and uses promise",
//   id: 1,
// });

//deletePost(1);
