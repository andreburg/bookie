/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
const canvas = document.getElementById('confetti-canvas');
const ctx = canvas.getContext('2d');
canvas.width = window.innerWidth;
canvas.height = window.innerHeight;

const colors = ['hsla(359, 14%, 38%, 45%)', 'hsla(359, 14%, 38%, 35%)', 'hsla(359, 14%, 38%, 25%)', 'hsla(36, 100%, 53%, 45%)', 'hsla(36, 100%, 53%, 35%)', 'hsla(36, 100%, 53%, 25%)'];

class ConfettiParticle {
    constructor(x, y, radius, color, speed, angle) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.speed = speed;
        this.angle = angle;
        this.rotation = Math.random() * 360;
        this.rotationSpeed = Math.random() * 10 - 5;
    }

    update() {
        this.y += this.speed;
        this.x += Math.cos(this.angle);
        this.rotation += this.rotationSpeed;

        if (this.y < 0) {
            this.y = canvas.height / 2;
            this.x = canvas.width / 2;
        }
    }

    draw() {
        ctx.save();
        ctx.translate(this.x, this.y);
        ctx.rotate(this.rotation * Math.PI / 180);
        ctx.beginPath();
        ctx.arc(0, 0, this.radius, 0, 2 * Math.PI);
        ctx.fillStyle = this.color;
        ctx.fill();
        ctx.restore();
    }
}

const confettiParticles = [];
for (let i = 0; i < 10; i++) {
    const radius = Math.random() * 5 + 10;
    const x = canvas.width / 2;
    const y = canvas.height / 2;
    const color = colors[Math.floor(Math.random() * colors.length)];
    const speed = -((Math.random() * 10)/(3/2));
    const angle = Math.random() * Math.PI * 2;
    confettiParticles.push(new ConfettiParticle(x, y, radius, color, speed, angle));
}

function animate() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    confettiParticles.forEach(particle => {
        particle.update();
        particle.draw();
    });

    requestAnimationFrame(animate);
}

animate();

window.addEventListener('resize', () => {
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;
});