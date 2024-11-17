import {Chart} from "chart.js";

export function initAdminDashboard() {
    // Initialize charts
    const applicationsChart = new Chart(
        document.getElementById('applicationsChart'),
        {
            type: 'line',
            data: {
                labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun'],
                datasets: [{
                    label: 'Applications',
                    data: [65, 59, 80, 81, 56, 55],
                    fill: false,
                    borderColor: 'rgb(75, 192, 192)',
                    tension: 0.1
                }]
            }
        }
    );

    const jobsChart = new Chart(
        document.getElementById('jobsChart'),
        {
            type: 'doughnut',
            data: {
                labels: ['Active', 'Pending', 'Closed'],
                datasets: [{
                    data: [300, 50, 100],
                    backgroundColor: [
                        'rgb(54, 162, 235)',
                        'rgb(255, 205, 86)',
                        'rgb(255, 99, 132)'
                    ]
                }]
            }
        }
    );
}

// Handle job status toggle
export function initJobToggle() {
    document.querySelectorAll('.job-status-toggle').forEach(toggle => {
        toggle.addEventListener('change', function() {
            const jobId = this.dataset.jobId;
            const status = this.checked ? 'active' : 'inactive';
            console.log(`Job ${jobId} status changed to ${status}`);
        });
    });
}

