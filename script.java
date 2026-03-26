const landing = document.getElementById('landing-page');
const chatPage = document.getElementById('chat-page');
const chatWindow = document.getElementById('chat-window');
const userInput = document.getElementById('user-input');
const sendBtn = document.getElementById('send-btn');

// 1. Logic to switch pages
function switchToChat() {
    landing.style.display = 'none';
    chatPage.classList.remove('hidden');
    chatPage.classList.add('flex');
}

// 2. Logic to add messages to the screen
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

// 3. Logic for the AI to "think" and reply
function getAIResponse(input) {
    const val = input.toLowerCase();
    
    if (val.includes("hi") || val.includes("hello")) return "Hey there, bestie! ✨ How are you feeling?";
    if (val.includes("test") || val.includes("grade 9")) return "You're going to slay that English test! 💅 Just keep practicing those synonyms.";
    if (val.includes("sad") || val.includes("bad")) return "I'm so sorry. 💗 I'm here for you. Want to tell me more?";
    
    return "I hear you. That sounds really interesting. Tell me more!";
}

// 4. Handle the Send Button
function handleSend() {
    const text = userInput.value.trim();
    if (!text) return;

    addMessage(text, true); // Add user's text
    userInput.value = '';

    setTimeout(() => {
        const response = getAIResponse(text);
        addMessage(response, false); // Add AI's text
    }, 800);
}

sendBtn.addEventListener('click', handleSend);
userInput.addEventListener('keypress', (e) => { if (e.key === 'Enter') handleSend(); });
