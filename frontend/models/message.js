let stompClient = null;

function connect() {
  const socket = new SockJS('http://localhost:8080/chat-websocket');
  stompClient = Stomp.over(socket);

stompClient.connect({}, (frame) => {
    console.log('Conectado:', frame);
    toggleUI(true);

stompClient.subscribe('/topic/message', (message) => {
      const msg = JSON.parse(message.body);
      showMessage(msg.text);
    });
  });
}

function disconnect() {
  if (stompClient !== null) {
    stompClient.disconnect(() => {
      console.log('Desconectado');
      toggleUI(false);
    });
  }
}

function sendMessage() {
  const input = document.getElementById('messageInput');
  const text = input.value.trim();
  if (text && stompClient) {
    stompClient.send('/app/message', {}, JSON.stringify({ from: 'cliente', text }));
    input.value = '';
  }
}

function showMessage(message) {
  const li = document.createElement('li');
  li.className = 'list-group-item';
  li.textContent = message;
  document.getElementById('messagesList').appendChild(li);
}

function toggleUI(connected) {
  document.getElementById('connectBtn').classList.toggle('d-none', connected);
  document.getElementById('disconnectBtn').classList.toggle('d-none', !connected);
  document.getElementById('chatBody').style.display = connected ? 'block' : 'none';
  document.getElementById('chatFooter').classList.toggle('d-none', !connected);
}

document.getElementById('connectBtn').addEventListener('click', connect);
document.getElementById('disconnectBtn').addEventListener('click', disconnect);
document.getElementById('sendBtn').addEventListener('click', sendMessage);
