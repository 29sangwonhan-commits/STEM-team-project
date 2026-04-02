const chatWindow = document.getElementById('chat-window');
const userInput = document.getElementById('user-input');

const responses = {
    "happy": "That's amazing! 💖 Keep that positive energy going. You're doing great!",
    "sad": "I'm so sorry you're feeling this way. 💗 Remember, it's okay to not be okay. I'm here for you.",
    "stress": "Take a deep breath. 🌬️ School can be hard, but you are capable of handling anything.",
    "exam": "You are more than your grades! 📖 Study a bit, then take a 10-minute break for yourself.",
    "lonely": "You're never alone with PinkMind AI around. 🫂 Reach out to a friend or listen to music.",
    "hello": "Hi bestie! ✨ I'm PinkMind AI. How can I help you feel better today?",
    "hi": "Hey! ✨ What's on your mind? I'm listening.",
    "thanks": "Anytime! 💖 I'm always here when you need me.",
    "joke": "Why did the student eat his homework? Because the teacher said it was a piece of cake! 🍰"
};

// Core function to add messages
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

// Function to handle the Chat sending
function handleSend() {
    const text = userInput.value.trim();
    if (!text) return;

    addMessage(text, true); // Display what the user typed
    userInput.value = ''; // Clear the input

    const low = text.toLowerCase();
    
    // Confetti for happy vibes
    if (low.includes('happy') || low.includes('proud')) {
        confetti({ particleCount: 100, spread: 70, origin: { y: 0.6 } });
    }

    setTimeout(() => {
        let response = "I hear you. 🌸 Tell me more about that? I'm here to listen and support you.";
        for (let key in responses) {
            if (low.includes(key)) {
                response = responses[key];
                break;
            }
        }
        addMessage(response, false);
    }, 800);
}

// Function for the Contact Form alert
function sendContact() {
    const btn = document.getElementById('contact-btn');
    btn.innerText = "SENT! ✅";
    btn.style.backgroundColor = "#4ade80"; 
    alert("SENT! Your message has been received by Kai and Jiwon.");
    
    setTimeout(() => {
        btn.innerText = "Send Message";
        btn.style.backgroundColor = "#ec4899";
    }, 3000);
}

// Allow pressing "Enter" to send
userInput.addEventListener('keypress', (e) => {
    if (e.key === 'Enter') handleSend();
});
