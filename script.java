// Function to scroll to chat and focus input
function openChat() {
    const chatInput = document.getElementById('chatInput');
    document.getElementById('chatWidget').scrollIntoView({ behavior: 'smooth' });
    chatInput.focus();
}

// Simple Chat functionality
function sendMessage() {
    const input = document.getElementById('chatInput');
    const body = document.getElementById('chatBody');
    
    if (input.value.trim() !== "") {
        const msg = document.createElement('p');
        msg.style.textAlign = "right";
        msg.innerHTML = `<strong>You:</strong> ${input.value}`;
        body.appendChild(msg);
        input.value = "";
        body.scrollTop = body.scrollHeight;
    }
}

// Breathing Game Logic
let isBreathing = false;
function toggleBreathing() {
    const circle = document.getElementById('breather');
    const text = document.getElementById('breathe-text');
    
    if (!isBreathing) {
        isBreathing = true;
        text.innerText = "Breathe In...";
        circle.classList.add('expand');
        
        setInterval(() => {
            if(circle.classList.contains('expand')) {
                circle.classList.remove('expand');
                text.innerText = "Breathe Out...";
            } else {
                circle.classList.add('expand');
                text.innerText = "Breathe In...";
            }
        }, 4000);
    }
}
