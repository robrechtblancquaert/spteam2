


 <nav class="navbar navbar-default ">
            <div class="container">
                <div class="navbar-header">

                    <!-- Collapsed Hamburger -->
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#app-navbar-collapse" aria-expanded="false">
                        <span class="sr-only">Toggle Navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <!-- Branding Image -->
                    <a class="navbar-brand" href="/home" id ="navbarColor">
                        {{ config('app.name', 'Laravel') }}
                    </a>
                </div>

                <div class="collapse navbar-collapse" id="app-navbar-collapse">
                    <!-- Left Side Of Navbar -->
                    <ul class="nav navbar-nav">
                        &nbsp;
                    </ul>
                    <ul class="nav navbar-nav">
                        <li > <a href ="/home" id ="navbarColor">Home</a>
                        
                        <li><a href ="/employee" id ="navbarColor"> Employees</a></li>
                        <li > <a href ="/trainings" id ="navbarColor">Trainings</a></li>
                        <li><a href="/books" id ="navbarColor">Books</a></li>
                        
                        
                        <li><a href="/certifications" id ="navbarColor">Certifications</a></li>
                        <li><a href="/surveys" id ="navbarColor">Surveys</a></li>
                        @if(Auth::user()->isHR())
                        <li><a href="/statistics" id ="navbarColor">Statistics</a></li>
                        <li><a href="/approval" id ="navbarColor">Approve Training</a></li>
                        @endif
                        
                     </ul>
                    <!-- Right Side Of Navbar -->
                    <ul class="nav navbar-nav navbar-right">
                        <!-- Authentication Links -->
                        @guest
                            <li><a href="{{ route('login') }}">Login</a></li>
                            <li><a href="{{ route('register') }}">Register</a></li>
                            <img hfre="">
                        @else
                            
                            <!--<li><a href="/trainings/create" id ="navbarColor">Add Training</a></li>-->
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false" aria-haspopup="true" id ="navbarColor">
                                    {{ Auth::user()->name }} <span class="caret"></span>
                                </a>

                                <ul class="dropdown-menu">
                                    <li><a href="/general">General</a></li>
                                    <li><a href="/settings">Settings</a></li>
                                    <li>
                                        <a href="{{ route('logout') }}"
                                            onclick="event.preventDefault();
                                                     document.getElementById('logout-form').submit();">
                                            Logout
                                        </a>

                                        <form id="logout-form" action="{{ route('logout') }}" method="POST" style="display: none;">
                                            {{ csrf_field() }}
                                        </form>
                                    </li>
                                </ul>
                            </li>
                        @endguest
                    </ul>
                </div>
            </div>
        </nav>