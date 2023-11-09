onload = () => {
  $('#headerUsername').text($util.getItem('managerInfo')[0].manager_account)
  handleHeaderLoad()
  fetchVolunteerList()
}

let volunteerList = []

const fetchVolunteerList = () => {
  let params = {
    volunteer_created_by: $util.getItem('managerInfo')[0].manager_account,
    volunteer_account: $('#volunteer_account').val(),
    volunteer_picture: $('#volunteer_picture').val()
  }
  $.ajax({
    url: API_BASE_URL + '/admin/queryVolunteerList',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      volunteerList = res.data
      $('#content').html('')

      res.data.map(item => {
        $('#content').append(`
          <div class="list">
            <div class="list-header">
             <div class="volunteer_account">
               <img src="${item.volunteer_picture}">
               <div>${item.volunteer_account}</div>
              </div>
              <div class="buttons">
                <button type="button" class="btn btn-link" onclick="onSeeVolunteer('${item.volunteer_account}')">查看志愿者信息</button>
                <button type="button" class="btn btn-link" onclick="onEditVolunteer('${item.volunteer_account}')">编辑志愿者信息</button>
                <button type="button" class="btn btn-link" onclick="onDelVolunteer('${item.volunteer_account}')">删除志愿者</button>
              </div>
            </div>
          </div>
        `)
      })
    }
  })
}


const onCreateVolunteer = () => {
  location.href = "/pages/createVolunteer/index.html"
}


const onSeeVolunteer = (id) => {
  $util.setPageParam('seeProject', id)
  location.href = "/pages/seeVolunteer/index.html"
}

const onEditVolunteer = (id) => {
  let project = projectList.filter(item => item.id === id)[0]
  $util.setPageParam('editProject', project)
  location.href = "/pages/editProject/index.html"
}

const onDelVolunteer = (volunteer_account) => {
  let state = confirm("确认删除该志愿者吗？")

  if (state) {
    let params = {
      volunteer_account:volunteer_account
    }
    //alert(JSON.stringify(params))
    $.ajax({
      url: API_BASE_URL + '/admin/deleteVolunteerByAccount',
      type: "POST",
      data: JSON.stringify(params),
      dataType: "json",
      contentType: "application/json",
      success(res) {
        alert(res.message)
        fetchVolunteerList()
      }
    })
  }
  
}
