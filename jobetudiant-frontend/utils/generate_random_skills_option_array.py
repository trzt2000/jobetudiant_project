technical_skills = {
    'programming_languages': ['Python', 'Java', 'JavaScript', 'C++', 'C#', 'Go', 'Swift', 'R', 'PHP'],
    'web_development': ['HTML', 'CSS', 'Bootstrap', 'React', 'Angular', 'Vue.js', 'Node.js'],
    'databases': ['SQL', 'MySQL', 'PostgreSQL', 'NoSQL', 'MongoDB'],
    'cloud_computing': ['AWS', 'Azure', 'Google Cloud Platform', 'Heroku', 'DigitalOcean'],
    'devops': ['Git', 'GitHub', 'Jenkins', 'Docker', 'Kubernetes'],
    'networking': ['TCP/IP', 'OSI model', 'Routing', 'VPN', 'Firewall'],
    'security': ['Cybersecurity', 'Cryptography', 'Penetration testing', 'Vulnerability management'],
    'data_analysis': ['Machine learning', 'Deep learning', 'Data visualization', 'Big data'],
    'it_maintenance': ['Troubleshooting', 'Helpdesk support', 'Operating systems (Windows, Linux, macOS)']
}


for x in technical_skills:
    for i in technical_skills[x]:
        print("{value : \"" + i +"\""+', label : ' + "\"" +i +"\""
              +"},")