import { values, Some, add } from "./data.js";
console.log(add(12, 13));

const obj = {
  id: 1,
  name: "anil",
  friends: ["sunil", "joydip", "mahesh", "suresh"],
};

// const idValue = obj.id;
// const nameValue = obj.name;
// const friendList = obj.friends;

//object destructuring
// const { id: idValue, name: nameValue, friends: friendList } = obj;
// console.log(idValue, nameValue);

// const id = obj.id;
// const name = obj.name;
// const friendList = obj.friends;

// const { id: id, name: name, friends: friendList } = obj;
const { id, name, friends: friendList } = obj;
console.log(id, name);

// const firstFriend = friendList[0];
// const thirdFriend = friendList[2];

//array destructuring
const [firstFriend, , thirdFriend] = friendList;
console.log(firstFriend, thirdFriend);
