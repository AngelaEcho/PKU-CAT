from django.contrib import admin
from django.urls import path, include
from django.http import HttpResponse
import post.views as post_views

urlpatterns = [
    path('demo', include('demo.urls')),
    path('file', include('file.urls')),
    path('file/', include('file.urls')),
    path('user', include('user.urls')),
    path('user/', include('user.urls')),
    path('pku/cat/helper/', admin.site.urls),
    path('test/hello/', include('demo.urls')),
    path('admin/', admin.site.urls),
    path('posts/', post_views.posts),
    path('posts/search/', post_views.search),
    path('post/', include('post.urls')),
    path('archive/', include('archive.urls')),
    path('feeder/', include('feeder.urls')),
]

def cat_not_found(request, exception):
    next_url = request.path_info
    return HttpResponse('404 '+str(next_url))
    
handler404 = cat_not_found
