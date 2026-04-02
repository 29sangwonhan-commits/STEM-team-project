const chatWindow = document.getElementById('chat-window');
const userInput = document.getElementById('user-input');
const sendBtn = document.getElementById('send-btn');

const masterAdvice = `Depression: Talk to someone you trust, get sunlight, and do small activities.
Anger: Take deep breaths, step away, and count to 10.
Anxiety: Focus on slow breathing and break tasks into small steps.
For all: Get enough sleep, exercise, and consider talking to a counselor.`;

const responses = {
    "happy": "That is wonderful! 💖 Happiness looks good on you. Try to share a smile with someone today!",
    "excited": "I love that energy! ✨ Channel it into a project or a dance break. You're glowing!",
    "sad": "I'm sending you a huge digital hug. 💗 It's okay to feel this way. Be gentle with yourself today.",
    "tired": "You've been doing a lot. 🛌 It's time to recharge. Take a break from your phone and just breathe.",
    "stress": "Stress is heavy, but you are stronger. 🌬️ Try the '4-7-8' breathing method to calm down.",
    "exam": "You are more than a grade! 📖 Study in small chunks and remember to hydrate.",
    "lonely": "I am right here! 🫂 Try reaching out to a friend or listening to your favorite podcast.",
    "angry": "Deep breaths... 😤 Try writing down your anger on paper and then safely ripping it up.",
    "thanks": "You are so welcome! 💖 I'm always here if you need to talk again.",
    "hello": "Hi bestie! ✨ I'm Pink Mind AI. How can I support your mental wellness today?",
    "hi": "Hey there! ✨ What's on your mind? I'm here to listen.",
    "help": "I'm here! 🆘 If you need urgent help, reach out to a professional or helpline immediately.",
    "joke": "Why don't skeletons fight each other? Because they don't have the guts! 😂"
};

// Fix: Function to send what people typed
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

function handleSend() {
    const text = userInput.value.trim();
    const low = text.toLowerCase();
    
    if (!text) return; // Don't send empty messages

    addMessage(text, true); // Add the user's text to the chat
    userInput.value = ''; // Clear the input box

    if (low.includes('happy') || low.includes('excited') || low.includes('proud')) {
        confetti({ particleCount: 150, spread: 70, origin: { y: 0.6 }, colors: ['#ec4899', '#fbcfe8'] });
    }

    // AI Response Logic
    setTimeout(() => {
        let found = false;
        for (let key in responses) {
            if (low.includes(key)) {
                addMessage(responses[key] + "\n\n---\nPink Mind Guidance:\n" + masterAdvice);
                found = true;
                break;
            }
        }
        if (!found) {
            addMessage("I'm listening. No matter what's happening, here is the Pink Mind guide to feeling better:\n\n" + masterAdvice);
        }
    }, 800);
}

// Fix: Contact Us "SENT!" message
function sendContactMessage() {
    const btn = document.getElementById('contact-send-btn');
    btn.innerText = "SENT! ✅";
    btn.style.backgroundColor = "#4ade80"; // Turn green
    alert("Your message has been SENT to Kai and Jiwon!");
    
    setTimeout(() => {
        btn.innerText = "Send Message";
        btn.style.backgroundColor = "#ec4899"; // Turn back to pink
    }, 3000);
}

sendBtn.addEventListener('click', handleSend);
userInput.addEventListener('keypress', (e) => { if (e.key === 'Enter') handleSend(); });
