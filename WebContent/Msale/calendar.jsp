<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />


  <title>
    Background Events - Demos | FullCalendar
  </title>


<link href='/assets/demo-to-codepen.css' rel='stylesheet' />


  <style>

    html, body {
      margin: 0;
      padding: 0;
      font-family: 'Malgun Gothic';
      font-size: 9pt;;
    }

    #calendar {
      max-width: 900px;
      margin: 40px auto;
    }

  </style>


<link href='https://unpkg.com/@fullcalendar/core@4.3.1/main.min.css' rel='stylesheet' />


  <link href='https://unpkg.com/@fullcalendar/daygrid@4.3.0/main.min.css' rel='stylesheet' />

  <link href='https://unpkg.com/@fullcalendar/timegrid@4.3.0/main.min.css' rel='stylesheet' />


<script src='/assets/demo-to-codepen.js'></script>

<script src='https://unpkg.com/@fullcalendar/core@4.3.1/main.min.js'></script>




  <script src='https://unpkg.com/@fullcalendar/daygrid@4.3.0/main.min.js'></script>

  <script src='https://unpkg.com/@fullcalendar/timegrid@4.3.0/main.min.js'></script>



  
<script>

  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      plugins: [ 'dayGrid', 'timeGrid' ],
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek'
      },
      defaultDate: '2020-02-12',
      events: [
        {
          start: '2020-02-11T10:00:00',
          end: '2020-02-11T16:00:00',
          rendering: 'background',
          color: '#ff9f89'
        },
        {
          start: '2020-02-13T10:00:00',
          end: '2020-02-13T16:00:00',
          rendering: 'background',
          color: '#ff9f89'
        },
        {
          start: '2020-02-24',
          end: '2020-02-28',
          overlap: false,
          rendering: 'background'
        },
        {
          start: '2020-02-06',
          end: '2020-02-08',
          overlap: false,
          rendering: 'background'
        }
      ]
    });

    calendar.render();
  });

</script>

</head>
<body>
  <div class='demo-topbar'>
  

  

  

  
</div>

  <div id='calendar'></div>
</body>

</html>
