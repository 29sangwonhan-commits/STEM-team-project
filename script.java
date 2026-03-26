const mainSite = document.getElementById('main-site');
const chatPage = document.getElementById('chat-page');
const chatWindow = document.getElementById('chat-window');
const userInput = document.getElementById('user-input');
const sendBtn = document.getElementById('send-btn');

// Fix: The function to show the chat and hide everything else
function switchToChat() {
    mainSite.classList.add('hidden'); // Hides Landing + About Us
    chatPage.classList.remove('hidden'); // Shows Chat
    console.log("Chat started!");
}

function addMessage(text, isUser = false) {
    const div = document.createElement('div');
    div.className = isUser ? "flex justify-end" : "flex justify-start";
    
    const bubble = document.createElement('div');
    bubble.className = isUser ? "chat-bubble-user" : "chat-bubble-ai";
    bubble.innerText = text;
    
    div.appendChild(bubble);
    chatWindow.appendChild(div);
    chatWindow.scrollTop = chatWindow.scrollHeight;
}

function getAIResponse(input) {
    const val = input.toLowerCase();
    
    if (val.includes("hi") || val.includes("hello")) return "Hey bestie! ✨ I was hoping you'd stop by. What's the tea?";
    if (val.includes("sad") || val.includes("bad")) return "I'm so sorry. 💗 You can vent to me as long as you need. I'm listening.";
    if (val.includes("test") || val.includes("exam")) return "Ugh, tests are the worst! But you're smart and capable. Want some quick study tips?";
    
    return "I totally get that. Tell me more? 🌸";
}

function handleSend() {
    const text = userInput.value.trim();
    if (!text) return;

    addMessage(text, true);
    userInput.value = '';

    // AI Delay
    setTimeout(() => {
        const response = getAIResponse(text);
        addMessage(response, false);
    }, 1000);
}

sendBtn.addEventListener('click', handleSend);
userInput.addEventListener('keypress', (e) => { if (e.key === 'Enter') handleSend(); });
